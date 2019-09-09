import React from 'react'
import '../../post.css'

class IntroMain extends React.Component {
    render() {
        return (
            <div className="row text-white header">
                <div className="col-md-12 text-left slogan align-self-end">
                    <div>
                        <p className="my-4 slogan-main">用科學評珍奶</p>
                        <p className="slogan-text">
                            儀器測量加上清楚數據<br />
                            好不好喝，一看就知<br />
                            bubble rater 給你最精確的珍奶指南
                    </p>
                    </div >
                </div>
            </div>
        )
    }
}

export default IntroMain