import React from 'react'
import '../post.css'
import store1 from '../images/store1.jpg'

export const StoreTop = (props) => {

    return (
        <div className="col-md-4 store change-top bg-blur text-white h-100">
            <div className="storeinfo change-first">
                <div className="text-center ranking">{props.rating}</div>
                <div className="text-center finalscore" text="">9.6</div>
                <div className="text-center store-name" text="">店家</div>
                <div className="text-center substore-name" text="">門市</div>
                <div className="text-center drink-name" text="">品名</div>
                <hr color="white" />
                <center>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td text="">珍珠彈性</td>
                                <td text=""></td>
                            </tr>
                            <tr>
                                <td text="">奶茶濃度</td>
                                <td text=""></td>
                            </tr>
                            <tr>
                                <td text="">珍探給分</td>
                                <td text=""></td>
                            </tr>
                            <tr>
                                <td text="">甜度等級</td>
                                <td text=""></td>
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
                                    <div id="aaa" text="">清心</div>
                                </td>
                                <td rowSpan="2">
                                    <div className="text-center" text="">8.9</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div text="">珍奶104</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td text="">珍珠彈性</td>
                                <td text="">90</td>
                            </tr>
                            <tr>
                                <td text="">奶茶濃度</td>
                                <td text="">90</td>
                            </tr>
                            <tr>
                                <td text=""> 珍探給分</td>
                                <td text="">90</td>
                            </tr>
                            <tr>
                                <td text="">甜度等級</td>
                                <td text="">甜膩</td>
                            </tr>
                        </tbody>
                    </table>
                    <p className="comment" text="">
                        小編評價巴拉巴拉巴拉
                        小編評價巴拉巴拉巴拉
                        小編評價巴拉巴拉巴拉
            </p>
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