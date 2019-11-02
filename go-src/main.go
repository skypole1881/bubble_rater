package main

import (
	"routes"

	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
)

func main() {
	// Echo instance
	e := echo.New()

	// Middlewaref
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	routes.Init(e)

	// Start server
	e.Logger.Fatal(e.Start(":1323"))
}
