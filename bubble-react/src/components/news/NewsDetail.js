import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../../post.css'
import brSmall from '../../images/br-newsimg-small.png'
import brBig from '../../images/br-newsimg-big.png'
import DimmableCard from '../DimmableCard'
import NewsCarousel from '../news/NewsCarousel'

class NewsDetail extends React.Component {
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

    const newsIconStyle = {
      width:'100%',
      minWidth: '70px',
      backgroundColor: '#86725A', 
      border: '2px solid #86725A',
      borderRadius: '35px',
      color: 'white',
      fontSize: '2.5rem',
      cursor: 'pointer',
    }

    const hrStyle = {
      border: '0.5px solid white',
      borderRadius: '3px'
    }

    const shareIconStyle = {
      color: 'red',
    }

    

    return (
      <div class="container-fluid" style={IntroNewsStyle}>
        <div class="row justify-content-between">
          <div class="col-2 col-lg-2 col-md-2" style={newsIconStyle}>
            News
          </div>
          <div class="col-4">
            <FontAwesomeIcon icon="coffee" size="20x"/>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
        <img src="..." class="rounded mx-auto d-block" alt="..."></img>
        </div>

        <hr style={hrStyle}></hr>

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

export default NewsDetail