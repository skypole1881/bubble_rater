import React from 'react'
import '../../post.css'
import brSmall from '../../images/br-newsimg-small.png'
import brBig from '../../images/br-newsimg-big.png'
import DimmableCard from '../DimmableCard'
import NewsCarousel from '../news/NewsCarousel'

class News extends React.Component {
  render() {
    const IntroNewsStyle = {
      backgroundColor: 'rgba(250,232,218)',
    };
    const brSmallCardStyle = {
      backgroundColor: 'rgba(250,232,218)',
    };
    const brSmallCardTitleStyle = {
      fontSize: '2.5em',
      fontWeight: '600',
      color: 'rgba(143, 119, 95)',
    }
    const brSmallCardTextStyle = {
      fontSize: '1.5em',
      color: 'rgb(145, 132, 122)',
    }
    const brBigStyle = {
      backgroundColor: 'rgba(250,232,218)',
      maxWidth: '70%',
    }
    const NewsRowStyle = {
      paddingTop: '30px',
    }
    const subNewsRowStyle = {
      marginTop: '30px',
      marginBottom: '30px',
    }

    const CarouselStyle = {
      // marginTop:'40px',
      // marginBottom: '40px',
      height: '100%',
    }

    

    return (
      <div class="container-fluid" style={IntroNewsStyle}>
        <div class="row" >
          <div class="col-6 mt-5 mb-1 mx-auto" style={CarouselStyle}>
            <NewsCarousel/>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col-3 mx-auto">
            <div class="card" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default News