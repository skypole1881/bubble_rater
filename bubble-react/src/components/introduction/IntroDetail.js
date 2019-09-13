import React from 'react'
import '../../post.css'
import img1 from '../../images/bubble-rater_logo-02.png'
import img2 from '../../images/bubble-rater_logo-03.png'
import img3 from '../../images/bubble-rater_logo-04.png'

const imgsArr = [img1, img2, img3]
class IntroDetail extends React.Component {
    

    render() {
        return (
            <div className="row text-center">
                <div className="col-md-4">
                    <img src={img1} alt="" data-src="../static/images/bubble-rater_logo-02.png" className="img-fluid lazyload" />
                    <p className="introduction-header text-left">珍珠到底有多Q？</p>
                    <hr color="white" />
                    <p className="introduction-text text-left">以彈性係數 (elastic modulus) 為測量目標，彈性係數愈高，珍珠愈 Q 彈！
我們在買到珍奶時迅速測量，避免珍珠在冷、熱茶品中結晶或溶解。利用儀器以 50% 的珍珠比例壓縮珍珠後，結合珍珠截面積的變化及產生的應力，得出珍珠的彈性係數。</p>
                    <div className="text-left">
                        <button type="button" className="modal-btn btn btn-outline-light"
                            data-toggle="modal" data-target="#Modal-introduction-bubble">
                            顯示更多</button>
                    </div>
                </div>
                <div className="col-md-4">
                    <img src={img2} alt="" data-src="../static/images/bubble-rater_logo-03.png" className="img-fluid lazyload" />
                    <p className="introduction-header text-left">奶茶到底有多濃？</p>
                    <hr color="white" />
                    <p className="introduction-text text-left">我們使用黏度 (viscosity) 作為測量目標。黏度愈高的奶茶，流動性愈差，口感愈濃郁。
以落球法測試奶茶黏度，在層流狀態下，在奶茶中落下的小球會因重力、浮力及黏滯阻力的力平衡達到終端速度，便可從此得知奶茶的黏度。</p>
                    <div className="text-left">
                        <button type="button" className="modal-btn btn btn-outline-light"
                            data-toggle="modal" data-target="#Modal-introduction-tea">
                            顯示更多</button>
                    </div>
                </div>
                <div className="col-md-4">
                    <img src={img3} alt="" data-src="../static/images/bubble-rater_logo-04.png" className="img-fluid lazyload" />
                    <p className="introduction-header text-left">奶茶到底有多甜？</p>
                    <hr color="white" />
                    <p className="introduction-text text-left">白利糖度 (Brix) 形容攝氏 20 度 C 下，每 100 公克水溶液中，溶解的蔗糖公克數。
我們以 4 °Bx、6 °Bx、8 °Bx、10 °Bx 以及 12 °Bx 的蔗糖溶液為比較基準，比較奶茶甜度與甜度比較基準的差異，判斷奶茶含糖量。</p>
                    <div className="text-left">
                        <button type="button" className="modal-btn btn btn-outline-light"
                            data-toggle="modal" data-target="#Modal-introduction-sweetness">
                            顯示更多</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default IntroDetail