import React from 'react'

class Searchbar extends React.Component {
    render() {
        return (
            <div className="sticky-nav" id="search">
                <div className="btn-group" role="group" aria-label="Button group with nested dropdown">
                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            篩選
                    </button>
                        <div className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <button type="button" className="dropdown-item filter_category"
                                value="cold"> 冷飲 </button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_category"
                                value="hot"> 熱飲 </button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_category"
                                value=""> 不拘 </button>
                        </div>
                    </div>
                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop2" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            我要找
                    </button>
                        <div className="dropdown-menu" aria-labelledby="btnGroupDrop2">
                            <button type="button" className="dropdown-item filter_region"
                                value="city">找縣市</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_region"
                                value="district">找區域</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_region"
                                value="store">找店家</button>
                        </div>
                    </div>

                    <select style={{}} id="query_suggeest" className="chosen-select text-reset" tabIndex="4">
                        <option value="123123123"></option>
                        <option value="123"></option>
                    </select>
                    <button type="button" id="GO" className="btn"> GO</button>

                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop3" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" value="totalRate">
                            排序
                    </button>
                        <div className="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupDrop3">
                            <button type="button" className="dropdown-item sort" value="totalRate">依照總分</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value="createdDtm">依照時間</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value="bubbleRatePR">珍珠彈性</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value="teaRatePR">奶茶口感</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value="godfeelingRate">小編評比</button>
                        </div>
                    </div>
                </div>
            </div >
        )
    }
}

export default Searchbar