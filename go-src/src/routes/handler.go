package routes

import (
	"database/sql"
	"fmt"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
	"github.com/labstack/echo"
)

// this db should have table
//      `bubble_user` with colums as User struct
func dbConn() (db *sql.DB) {
	dbDriver := "mysql"
	dbUser := "root"
	dbPass := "root"
	dbName := "blog"
	db, err := sql.Open(dbDriver, dbUser+":"+dbPass+"@/"+dbName)
	if err != nil {
		panic(err.Error())
	}
	return db
}

type User struct {
	User_id       int    `json:"user_id"`
	User_name     string `json:"user_name"`
	User_password string `json:"user_password"`
	User_email    string `json:"user_email"`
	Admin         int    `json:"admin"`
}

func Init(e *echo.Echo) {
	e.GET("/", func(c echo.Context) error {
		return c.JSON(http.StatusOK, "Hi!")
	})
	e.GET("/users", list_user)
	e.GET("/users/:id", list_user_by_id)
	e.POST("/users", create_user)
	e.DELETE("/users/:id", delete_user)
}

func list_user(c echo.Context) error {
	db := dbConn()
	res, err := db.Query(`SELECT * FROM bubble_user`)
	if err != nil {
		return c.String(400, "fail")
	}
	users := make([]User, 0)
	for res.Next() {
		var user User
		// for each row, scan the result into our tag composite object
		err = res.Scan(
			&user.User_id,
			&user.User_name,
			&user.User_password,
			&user.User_email,
			&user.Admin)
		users = append(users, user)
	}
	return c.JSONPretty(http.StatusOK, users, "  ")
}

func list_user_by_id(c echo.Context) error {
	db := dbConn()
	id := c.Param("id")
	fmt.Println("test")
	fmt.Println(id)
	fmt.Println("test")
	var user User
	res := db.QueryRow(`
		SELECT *
		FROM bubble_user
		WHERE user_id = `+id).Scan(
		&user.User_id,
		&user.User_name,
		&user.User_password,
		&user.User_email,
		&user.Admin)
	fmt.Println(res)
	return c.JSONPretty(http.StatusOK, user, "  ")
}

// curl \
//   -X POST \
//   http://localhost:1323/users \
//   -H 'Content-Type: application/json' \
//   -d '{"user_id": "5", "user_name": "api", "user_password": "api", "user_email":"api@api", "admin": -1}'
func create_user(c echo.Context) (err error) {
	db := dbConn()
	u := new(User)
	if err = c.Bind(u); err != nil {
		return
	}
	q_msg := fmt.Sprintf(
		`INSERT into bubble_user
			(user_id, user_name, user_password, user_email, admin)
		values
			('%d', '%s', '%s', '%s', '%d')`,
		u.User_id, u.User_name, u.User_password,
		u.User_email, u.Admin)
	_, err = db.Query(q_msg)
	return c.JSONPretty(http.StatusOK, u, "  ")
}

func delete_user(c echo.Context) (err error) {
	db := dbConn()
	id := c.Param("id")
	res, err := db.Exec(`DELETE FROM bubble_user WHERE user_id = ` + id)
	if err != nil {
		return
	}
	numDeleted, err := res.RowsAffected()
	return c.String(http.StatusOK, string(numDeleted))
}
