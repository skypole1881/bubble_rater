import React, { Component } from 'react';
import Radium from 'radium';
import {Spring} from 'react-spring/renderprops';
import { bounce } from 'react-animations';
import { Button, Dimmer, Header, Image } from 'semantic-ui-react';
import brSmall from '../images/br-newsimg-small.png';
import johnBlackTeaImg from '../images/johnBlackTeaImg.png';
import ClampLines from 'react-clamp-lines';
import Background from '../images/carousel/kebuke.jpg';



class DimmableCard extends Component {
  constructor(props) {
    super(props);
    this.handleMouseHover = this.handleMouseHover.bind(this);
    this.state = {
      isHovering: false,
    };
  }

  handleMouseHover() {
    this.setState(this.toggleHoverState);
  }

  toggleHoverState(state) {
    return {
      isHovering: !state.isHovering,
    };
  }


  render() {
    const rankCard = {
      color: 'black',
    }



    const cardTopContentStyle = {
      fontSize: '3rem',
      marginTop: '25px',

    }

    const hrStyle = {
      border: '0.5px solid white',
      borderRadius: '3px'
    }

    const cardBodyStyle = {
      fontSize: '2rem',
      backgroundColor: '#AC8135',
      color: 'white',
    }

    const dimmerCard = {
      base:{
        backgroundColor: 'black',
        transition: 'all 1s',
        // 
        ':hover': {
          // backgroundImage: `url(${Background})`,
          backgroundColor: 'yellow',
        },

        bounce: {
          animation: 'x 4s',
          animationName: Radium.keyframes(bounce, 'bounce')
        }
      // transform: `translateY(-50%)`
      },    
    }

    const dimmerCardHeadStyle = {
      borderLeft: '6px #875111 solid'
    }

    const dimmerCardBodyStyle = {
      fontSize: '2rem',
      color: 'black',
    }

    const DimmerCardContentStyle ={
      overflow: 'hidden',
      whiteSpace: 'nowrap',
      textOverflow: 'ellipsis',
      display: '-webkit-box',
      WekitLineClamp: '2',
      WekitBoxOrient: 'vertical',
      whiteSpace: 'normal',
    }
    return (

      <div>
        {/* {this.state.isHovering === false &&
          <div class="card h-100"
            style={rankCard}
            onMouseEnter={this.handleMouseHover}
            onMouseLeave={this.handleMouseHover}>
            <img src={brSmall} class="card-img-top" alt="..."></img>
            <div class="card-body"
              style={cardBodyStyle}>
              <div class="container">
                <div class="row"
                  style={cardTopContentStyle}>
                  <div class="col d-flex flex-column">
                    <div class="p-2 bd-highlight align-self-center">約翰紅茶公司</div>
                    <div class="p-2 bd-highlight align-self-center">南港店</div>
                    <div class="p-2 bd-highlight align-self-center">雨果那堤</div>
                  </div>
                </div>

                <hr style={hrStyle}></hr>

                <div class="row">
                  <div class="col d-flex flex-row">
                    珍珠彈性
                  </div>
                  <div class="col d-flex flex-row-reverse">
                    9.8
                  </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    奶茶濃度
                  </div>
                  <div class="col d-flex flex-row-reverse">
                    9.5
                  </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    珍探給分
                  </div>
                  <div class="col d-flex flex-row-reverse">
                    9.5
                  </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    甜度等級
                  </div>
                  <div class="col d-flex flex-row-reverse">
                    剛剛好
                  </div>
                </div>
              </div>
            </div>
          </div>

        } */}
        {<Spring
          from={{ opacity: 0 }}
          to={{ opacity: 1 }}>
          {props => <div style={props}>hello</div>}
        </Spring>}

        {true &&
          <div class="card h-65"
            style={dimmerCard.bounce}
            onMouseEnter={this.handleMouseHover}
            onMouseLeave={this.handleMouseHover}>
            <div class="card-body"
              style={dimmerCardBodyStyle}>
              <div class="container">
                <div class="row"
                  style={dimmerCardHeadStyle}>
                  <div class="col d-flex flex-column">
                    <div class="p-2 bd-highlight align-self-start">約翰紅茶公司</div>
                    <div class="p-2 bd-highlight align-self-start">南港店</div>
                    <div class="p-2 bd-highlight align-self-start">雨果那堤</div>
                  </div>
                </div>

                <hr style={hrStyle}></hr>

               <div class="row">
                  <div class="col d-flex flex-row">
                    珍珠彈性
                </div>
                  <div class="col d-flex flex-row-reverse">
                    9.8
                </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    奶茶濃度
                </div>
                  <div class="col d-flex flex-row-reverse">
                    9.5
                </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    珍探給分
                </div>
                  <div class="col d-flex flex-row-reverse">
                    9.5
                </div>
                </div>
                <div class="row">
                  <div class="col d-flex flex-row">
                    甜度等級
                </div>
                  <div class="col d-flex flex-row-reverse">
                    剛剛好
                  </div>
                </div>

                <hr style={hrStyle}></hr>

                <div class="row">
                <ClampLines
                  text={'白玉珍珠Q彈不軟爛，雖有些破碎的珍珠，但瑕不掩瑜，奶茶口味清淡，微微蔗糖風味，相當順口。不要對我尖叫，日常茶間(無法一口氣念完的名字)是藝人丫頭開的店，霓虹招牌相當有特色，店內附座位(但沒冷氣)，坐落於東區人氣手搖店SOMA附近。飲品表現超乎預期，尤其白玉珍珠煮的好，麻煩老闆看到給早班的員工獎金。'
                  }
                  id="1"
                  lines={6}
                  ellipsis="..."
                  moreText="more"
                  lessText="Collapse"
                  className="custom-class"
                  innerElement="p"
                />
                </div>



                <hr style={hrStyle}></hr>


              </div>
            </div>
          </div>         
        }
      </div>

    );
  }
}

export default Radium(DimmableCard)