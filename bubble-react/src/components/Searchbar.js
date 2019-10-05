import React from 'react'

class Searchbar extends React.Component {
    constructor(props) {
        super(props)
        
    }
    render() {
        return (
            <div className="sticky-nav" id="search">
                <div className="btn-group" role="group" aria-label="Button group with nested dropdown">
                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" value={this.props.chosen[0].btnGroupDropValue}>{this.props.chosen[0].btnGroupDropText}</button>
                        <div className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <button type="button" className="dropdown-item filter_category"
                                value={'cold'} onClick={this.props.handleClick}>冷飲</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_category"
                                value={'hot'} onClick={this.props.handleClick}>熱飲</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_category"
                                value={''} onClick={this.props.handleClick}>不拘</button>
                        </div>
                    </div>
                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop2" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" value={this.props.chosen[1].btnGroupDropValue}>{this.props.chosen[1].btnGroupDropText}</button>
                        <div className="dropdown-menu" aria-labelledby="btnGroupDrop2">
                            <button type="button" className="dropdown-item filter_region"
                                value={'city'} onClick={this.props.handleClick}>找縣市</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_region"
                                value={'district'} onClick={this.props.handleClick}>找區域</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item filter_region"
                                value={'store'} onClick={this.props.handleClick}>找店家</button>
                        </div>
                    </div>

                    <select style={{}} id="query_suggeest" className="chosen-select text-reset" tabIndex="4" onChange={this.props.onChange}>
                        {
                            this.props.dropDownList.map(
                                (dropDownItem, index) => {
                                    return(
                                        dropDownItem == '搜尋更多' ? <option key={index} value={''}>{dropDownItem}</option>
                                        :
                                        <option key={index} value={dropDownItem}>{dropDownItem}</option>
                                    )
                                    
                                }
                            )
                        }
                    </select>
                    <button type="button" id="GO" className="btn" onClick={this.props.submitSearch}>GO</button>

                    <div className="btn-group" role="group">
                        <button id="btnGroupDrop3" type="button" className="btn text-white dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" value={this.props.chosen[2].btnGroupDropValue}>{this.props.chosen[2].btnGroupDropText}</button>
                        <div className="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupDrop3">
                            <button type="button" className="dropdown-item sort" value={'totalRate'} onClick={this.props.handleClick}>依照總分</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value={'createdDtm'} onClick={this.props.handleClick}>依照時間</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value={'bubbleRatePR'} onClick={this.props.handleClick}>珍珠彈性</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value={'teaRatePR'} onClick={this.props.handleClick}>奶茶口感</button>
                            <div className="dropdown-divider"></div>
                            <button type="button" className="dropdown-item sort" value={'godfeelingRate'} onClick={this.props.handleClick}>小編評比</button>
                        </div>
                    </div>
                </div>
            </div >
        )
    }
}

export default Searchbar