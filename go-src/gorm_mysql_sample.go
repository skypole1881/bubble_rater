package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type BubbleUser struct {
	User_id       int    `gorm:"primary_key"`
	User_name     string `gorm:"not_null"`
	User_password string `gorm:"not_null"`
	User_email    string `gorm:"not_null"`
	Admin         int    `gorm:"not_null"`
}

func main() {
	db, err := gorm.Open("mysql", "root:root@(127.0.0.1:3306)/blog?charset=utf8&parseTime=True&loc=Local")
	if err != nil {
		fmt.Println(err)
	}
	defer db.Close()
	user := &BubbleUser{User_id: 1, User_name: "zhangsan", User_password: "1234", User_email: "1234", Admin: 1}
	// db.Table("bubble_user").Create(user)
	db.Table("bubble_user").Delete(&user)

}
