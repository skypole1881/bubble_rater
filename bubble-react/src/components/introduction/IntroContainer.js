import React from 'react'
import IntroMain from './IntroMain'
import IntroBot from './IntroBot'
import IntroDetail from './IntroDetail'
import IntroSub from './IntroSub'
import IntroNews from './IntroNews'
import Coupons from '../coupons/Coupons'
import NewsDetail from '../news/NewsDetail'

class IntroContainer extends React.Component {
  render() {
    return (
      <div className="container-fluid text-white" id="about">
        <IntroMain />
        <IntroSub />
        <IntroNews />
        <IntroDetail />
        <IntroBot />
        {/* <Coupons /> */}
        {/* <NewsDetail /> */}
      </div>
    )
  }
}

export default IntroContainer