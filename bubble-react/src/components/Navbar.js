import React from 'react'
import '../post.css'
import logo16 from '../images/bubble rater_logo-16.png'
import logo15 from '../images/bubble rater_logo-15.png'

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-black fixed-top navbar-font" style={{backgroundColor: 'rgba(215, 199, 179, 0.6)'}} id="nav-bar-spy">
            <div className="container-fluid">
            <a className="navbar-brand" href="https://www.bubblerater.com/">
                <img src={logo16} alt="logo16" className="img-fluid" />
                <img src={logo15} alt="logo15" className="img-fluid" />
            </a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive"
                aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarResponsive">
                <ul className="nav navbar-nav ml-auto text-nowrap">
                <li className="nav-item ">
                    <a className="nav-link active" href="#about">News & Coupons
                    <span className="sr-only">(current)</span>
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#stores">About Us</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#contact">Rate</a>
                </li>
                </ul>
                <div className="dropdown-divider"></div>
                <div className="divider text-white-50">|</div>
                <ul className="nav navbar-nav text-nowrap">
                <li className="nav-item ">
                    <a className="nav-link" href="?lang=zh">中</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="?lang=ja">日</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="?lang=en">ENG</a>
                </li>
                </ul>
            </div>
            </div>
        </nav>
    )
}


export { Navbar };