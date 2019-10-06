import React from 'react'
import '../post.css'
import store1 from '../images/store1.jpg'

export const Background = (props) => {
    const backgroundstyle = {
        position: 'absolute',
        width: 'calc(100% + 10px)',
        height: 'calc(100% + 10px)',
        backgroundImage: 'url('+(props.photoLink || store1)+')',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        filter: 'blur(5px)',
        content:"",
        top: 0,
        bottom: 0,
        left: 0,
        margin: '-5px',
    };
    return <div style={backgroundstyle} className="change-first"></div>
}