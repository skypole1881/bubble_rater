import React from 'react'

const Store = (props) => {
    return (
        <div className="col-md-4 text-white otherstore change-top">
            <div className="otherinfo">
                <div className="bg-blur">
                    <table className="storename text-center">
                        <tbody>
                            <tr>
                                <td>
                                    <div>{props.store.storeBrand}</div>
                                </td>
                                <td rowSpan="3">
                                    <div>{props.store.totalRate.toFixed(1)}</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>{`${props.store.storeCity}-${props.store.storeDistrict}`}</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>{props.store.item}</div>
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
                                    <div>{props.store.storeBrand}</div>
                                </td>
                                <td rowSpan="2">
                                    <div className="text-center">{props.store.totalRate.toFixed(1)}</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>{props.store.item}</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table className="scoretable">
                        <tbody>
                            <tr>
                                <td>珍珠彈性</td>
                                <td>{props.store.bubbleRatePR.toFixed(1)}</td>
                                <td>珍探給分</td>
                                <td>{props.store.godfeelingRate.toFixed(1)}</td>
                            </tr>
                            <tr>
                                <td>奶茶濃度</td>
                                <td>{props.store.teaRatePR.toFixed(1)}</td>
                                <td>甜度等級</td>
                                <td>{props.store.sweetness}</td>
                            </tr>
                        </tbody>
                    </table>
                    <p className="comment">{props.store.content1}</p>
                    <button type="button" className="btn btn-outline-light btn-sm modal-btn" data-toggle="modal" data-target="#myModal">顯示更多</button>
                    <a href="#"
                        className="btn btn-outline-light btn-sm single-link">顯示更多</a>
                    <div className="d-none" id="invisibleId">看不到</div>
                </div>
            </div>
            <div className="newstore">
                新 進 榜
            </div>
        </div>
    )
}

export { Store }