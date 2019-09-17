import React from 'react'

const Store = () => {
    return (
        <div className="col-md-4 text-white otherstore change-top">
            <div className="otherinfo">
                <div className="bg-blur">
                    <table className="storename text-center">
                        <tbody>
                            <tr>
                                <td>
                                    <div text="">清心</div>
                                </td>
                                <td rowSpan="3">
                                    <div text="">8.9</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div text="">宜蘭縣蘇澳鎮</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div text="">珍奶半糖去冰</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div className="othercomment change-second bg-blur">
                <div>
                    <table className="storename">
                        <tbody>
                            <tr>
                                <td>
                                    <div text="">清心</div>
                                </td>
                                <td rowSpan="2">
                                    <div className="text-center" text="">8.9</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div text="">珍奶半糖去冰</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td text="">珍珠彈性</td>
                                <td text="">90</td>
                                <td text="">珍探給分</td>
                                <td text="">90</td>
                            </tr>
                            <tr>
                                <td text="">奶茶濃度</td>
                                <td text="">90</td>
                                <td text="">甜度等級</td>
                                <td text="">中等</td>
                            </tr>
                        </tbody>
                    </table>
                    <p className="comment" text="">
                        小編評價巴拉巴拉巴拉
                        小編評價巴拉巴拉巴拉
                        小編評價巴拉巴拉巴拉
                    </p>
                    <button type="button" className="btn btn-outline-light btn-sm modal-btn" data-toggle="modal" data-target="#myModal">顯示更多</button>
                    <a href="#"
                        className="btn btn-outline-light btn-sm single-link">顯示更多</a>
                    <div className="d-none" id="invisibleId" text="">看不到</div>
                </div>
            </div>
            <div className="newstore" text="">
                新 進 榜
            </div>
        </div>
    )
}

export { Store }