import React from 'react'
import '../post.css'

class IntroBot extends React.Component {
    render() {
        return (
            <div className="row justify-content-center">
                <div className="col-md-12 text-center">
                    <p className="introduction-conclusion">
                        想睡了？好麻煩？<br />
                        別擔心， Bubble Rater 把最終分數轉換成 5～10 分，讓你一目瞭然。<br />
                        測量、踩雷交給我們，最好喝的珍珠奶茶留給你！
                    </p>
                </div>
            </div>
        )
    }
}

export default IntroBot