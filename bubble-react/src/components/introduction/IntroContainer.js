import React from 'react'
import IntroMain from './IntroMain'
import IntroBot from './IntroBot'
import IntroDetail from './IntroDetail'
import IntroSub from './IntroSub'

class IntroContainer extends React.Component {
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

export default IntroContainer