import React from 'react'
import '../post.css'

export const Mask = (props) => {
    const style = {
        position: 'absolute',
        width: '100%',
        height: '100%',
        background: props.color || 'hsla(0,0%,0%,0.5)',
        content: "",
        top: '0px',
        left: '0px'
    }
    return <div style = {style} class="change-first"></div>
}