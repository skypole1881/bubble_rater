import React from 'react'
import IntroMain from './IntroMain'
import IntroSub from './IntroSub'
import IntroDetail from './IntroDetail'
import IntroBot from './IntroBot'

class Header extends React.Component {
    render() {
        return (
            <div className="container-fluid text-white" id="about">
                <IntroMain />
                <IntroSub />
                <IntroDetail />
                <IntroBot />
            </div>
        )
    }
}

export default Header