import React from 'react'
import Searchbar from './Searchbar'
import { StoreTop } from './StoreTop'
import IntroContainer from './introduction/IntroContainer'
import { Store } from './Store'

const ratingArr = ["第一名", "第二名", "第三名"];

class MainContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            stores: [],
            chosen: [
                { id: 1, btnGroupDropText: '篩選', btnGroupDropValue: '' },
                { id: 2, btnGroupDropText: '我要找', btnGroupDropValue: '' },
                { id: 3, btnGroupDropText: '排序', btnGroupDropValue: 'totalRate' },
            ],
            cdt: {
                cold: '',
                criteria: '',
                orderby: 'totalRate',
                keyword: '',
                limitNumStart: 0,
                limitNumEnd: 12,
            },
            dropDownList: [],
        }
        this.handleClick = this.handleClick.bind(this)
        this.submitSearch = this.submitSearch.bind(this)
        this.dropDownOptionOnChange = this.dropDownOptionOnChange.bind(this)
    }
    componentDidMount() {
        let url = 'http://localhost:8080/react'
        fetch(url, {
                method: 'POST',
                headers: new Headers({
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify(this.state.cdt),
            }).then(res => res.json())
            .then((data) => {
            console.log('**** TCL : MainContent -> componentDidMount -> data', data);
                this.setState({ stores: data.stores })
                let dropDownListTemp = data.dropDownList
                data.dropDownList[0] == null && (dropDownListTemp[0] = '搜尋更多')
                this.setState({dropDownList: dropDownListTemp})
            })
            .catch(function(reason) {
            console.log('**** TCL : MainContent -> componentDidMount -> reason', reason);
            })
    }
    handleClick(e) {
        let className = e.target.className.split(' ')[1]
        let cdtCopy = this.state.cdt
        switch (className) {
            case 'filter_category':
                this.updateItem(1, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                cdtCopy.cold = e.target.value
                this.setState({cdt: cdtCopy})
                this.filterOnChange()
                break;
            case 'filter_region':
                this.updateItem(2, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                cdtCopy.criteria = e.target.value
                this.setState({cdt: cdtCopy})
                this.filterOnChange()
                break;
            case 'sort':
                this.updateItem(3, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                cdtCopy.orderby = e.target.value
                this.setState({cdt: cdtCopy})
                break;
        }
    }
    filterOnChange(){
        let url = 'http://localhost:8080/reactquerykeyword'
        fetch(url, {
            method: 'POST',
            headers: new Headers({
                'Content-Type': 'application/json'
            }),
            body: JSON.stringify(this.state.cdt),
        }).then(res => res.json())
        .then((data) => {
            this.setState({ dropDownList: data })
        })
        .catch()
    }
    updateItem(id, itemAttributes) {
        var index = this.state.chosen.findIndex(x => x.id === id);
        if (index === -1) { }
        else {

            this.setState({
                chosen: [
                    ...this.state.chosen.slice(0, index),
                    Object.assign({}, this.state.chosen[index], itemAttributes),
                    ...this.state.chosen.slice(index + 1)
                ]
            });
        }
    }
    dropDownOptionOnChange(e){
        let cdtCopy = this.state.cdt
        cdtCopy.keyword = e.target.value
        this.setState({cdt: cdtCopy})
    }
    submitSearch(e) {
        console.log(this.state.cdt)
        let url = 'http://localhost:8080/reactSearch'
        fetch(url, {
                method: 'POST',
                headers: new Headers({
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify(this.state.cdt),
            }).then(res => res.json())
            .then((data) => {
                this.setState({ stores: data })
            })
            .catch()
    }
    render() {
        return (
            <div>
                <IntroContainer />
                <div className="container-fluid text-white" id="stores">
                    <Searchbar
                        handleClick={this.handleClick}
                        submitSearch={this.submitSearch}
                        chosen={this.state.chosen}
                        dropDownList={this.state.dropDownList}
                        onChange={this.dropDownOptionOnChange}
                    />
                    <div className="row no-gutters justify-content-md-center">
                        {
                            this.state.stores.slice(0, 3).map(
                                (store, index) => {
                                    return <StoreTop key={store.blogId} rating={ratingArr[index]} store={store} />
                                }
                            )
                        }
                    </div>
                    <div id="blogAppend" className="row no-gutters justify-content-md-center">
                        {
                            this.state.stores.slice(3).map(
                                (store) => <Store key={store.blogId} store={store} />
                            )
                        }
                    </div>
                </div>
            </div>
        )
    }
}

export default MainContent