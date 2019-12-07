import React, { Component } from 'react'
import { Button, Dimmer, Header, Image } from 'semantic-ui-react'
import brSmall from '../images/br-newsimg-small.png'

class Dimmer extends Component {
  constructor(props) {
    super(props);
  }

  handleMouseHover() {
    this.setState(this.toggleHoverState);
  }

  toggleHoverState(state) {
    return {
      isHovering: !state.isHovering,
    };
  }

  toggleCardDisplay(state) {
    return {
      isShowingCard: !state.isShowingCard,
    };
  }
 

  render() {
    return (
      <div>
        <div class="card"
             onMouseEnter={this.handleMouseHover}
             onMouseLeave={this.handleMouseHover}>
            <img src={brSmall} class="card-img-top" alt="..."></img>
              <div class="card-body">
                <h5 class="card-title" >珍奶拚觀光 珍探來沾光</h5>
                <p class="card-text" >小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶小英總統喝珍奶</p>
              </div>
        </div>
        {this.state.isHovering && <div>Hovering right meow! 🐱</div>}
      </div>
    );
  }
  // render() {
  //   return (
  //     <div>
  //       <div
  //         onMouseEnter={this.handleMouseHover}
  //         onMouseLeave={this.handleMouseHover}
  //       >
  //         Hover Me
  //       </div>
  //       {this.state.isHovering && <div>Hovering right meow! 🐱</div>}
  //     </div>
  //   );
  // }
}

export default Dimmer