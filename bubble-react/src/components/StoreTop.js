import React from 'react'
import '../post.css'
import store1 from '../images/store1.jpg'

export const StoreTop = (props) => {

    return (
        <div className="col-md-4 store change-top bg-blur text-white h-100">
            <div className="storeinfo change-first">
                <div className="text-center ranking">{props.rating}</div>
                <div className="text-center finalscore">{props.blog.totalRate.toFixed(1)}</div>
                <div className="text-center store-name">{props.blog.storeBrand}</div>
                <div className="text-center substore-name">{`${props.blog.storeCity}-${props.blog.storeDistrict}`}</div>
                <div className="text-center drink-name">{props.blog.item}</div>
                <hr color="white" />
                <center>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td text="">珍珠彈性</td>
                                <td>{props.blog.bubbleRatePR.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text="">奶茶濃度</td>
                                <td>{props.blog.teaRatePR.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text="">珍探給分</td>
                                <td>{props.blog.godfeelingRate.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text="">甜度等級</td>
                                <td>{props.blog.sweetness}</td>
                            </tr>
                        </tbody>
                    </table>
                </center>
            </div>
            <div className="text-white change-second storecomment text-center">
                <img className="img-fluid" src={store1} alt="" />

                <div className="text-left">
                    <table className="storename">
                        <tbody>
                            <tr>
                                <td>
                                    <div id="aaa">{props.blog.storeBrand}</div>
                                </td>
                                <td rowSpan="2">
                                    <div className="text-center">{props.blog.totalRate.toFixed(1)}</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>{props.blog.item}</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td text="">珍珠彈性</td>
                                <td>{props.blog.bubbleRatePR.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text="">奶茶濃度</td>
                                <td>{props.blog.teaRatePR.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text=""> 珍探給分</td>
                                <td>{props.blog.godfeelingRate.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td text="">甜度等級</td>
                                <td>{props.blog.sweetness}</td>
                            </tr>
                        </tbody>
                    </table>
                    <p className="comment">{props.blog.content1}</p>
                    <button type="button" className="btn btn-outline-light btn-sm modal-btn" data-toggle="modal" data-target="#myModal">顯示更多</button>
                    <a href="#" className="btn btn-outline-light btn-sm single-link"
                    >顯示更多</a>
                    <div className="d-none">看不到</div>
                </div>
            </div>
            <div className="newstore" text="">
                新 進 榜
        </div>
        </div>
    )
}