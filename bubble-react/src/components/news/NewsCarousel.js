import React, { Component } from 'react';
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from 'react-responsive-carousel';

class NewsCarousel extends Component {
    render() {
        return (
            <Carousel infiniteLoop 
                      autoPlay
                      showStatus={false}>
                <div>
                    <img src="https://farm5.staticflickr.com/4798/26898676488_6b53081c44_b.jpg" />
                    <p className="legend">約翰紅茶公司</p>
                </div>
                <div>
                    <img src="https://cdn.walkerland.com.tw/images/upload/subject/3e243a63e89b25fa6e3c600f091cd1eeaeef998b.jpg" />
                    <p className="legend">JIATE呷茶</p>
                </div>
                <div>
                    <img src="https://i1.wp.com/img.dingeat.com/uploads/20180626010147_72.jpg" />
                    <p className="legend">可不可熟成紅茶</p>
                </div>
            </Carousel>
        );
    }
}

export default NewsCarousel