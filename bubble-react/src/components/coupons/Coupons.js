import React from 'react'
import '../../post.css'
import brSmall from '../../images/br-newsimg-small.png'
import brBig from '../../images/br-newsimg-big.png'
import DimmableCard from '../DimmableCard'

class Coupons extends React.Component {
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

    const rankRowStyle = {
      minHeight: '400px',
      maxHeight: '400px',
    }

    const btnNewsStyle = {
      width:'100%',
      minWidth: '70px',
      backgroundColor: '#8EADD', 
      border: '2px solid #84745D',
      borderRadius: '35px',
      color: '#84745D',
      fontSize: '2.5rem',
      cursor: 'pointer',
    }

    const btnCouponStyle = {
      width:'100%',
      minWidth: '70px',
      backgroundColor: '#EB3365', 
      border: '2px solid #EB3365',
      borderRadius: '35px',
      color: 'white',
      fontSize: '2.5rem',
      cursor: 'pointer',
    }

    return (
      <div class="container-fluid" style={IntroNewsStyle}>
        <div class="row justify-content-center">
          <div class="col-lg-2 .col-2	.col-sm-3	.col-md-3 text-center">
            <button type="button" class="btn btn-lg" style ={btnNewsStyle}>News</button>
          </div>
          <div class="col-lg-2 .col-2	.col-sm-3	.col-md-3 text-center">
            <button type="button" class="btn btn-lg"style ={btnCouponStyle} >Coupons</button>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
        </div>
        <div class="row" style={subNewsRowStyle}>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card border-0" style={brSmallCardStyle}>
              <img src={brSmall} class="card-img-top rounded-circle" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title text-center" style={brSmallCardTitleStyle}>珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" style={brSmallCardTextStyle}>小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default Coupons