import React from 'react'
import Searchbar from './Searchbar'
import { StoreTop } from './StoreTop'
// import IntroBot from './introduction/IntroBot'
// import IntroMain from './introduction/IntroMain'
// import IntroSub from './introduction/IntroSub'
// import IntroDetail from './introduction/IntroDetail'
import IntroContainer from './introduction/IntroContainer'
import { Store } from './Store'

const ratingArr = ["第一名", "第二名", "第三名"];

class MainContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            numberofblogs: 9,
            stores: [],
            chosen: [
                { id: 1, btnGroupDropText: '篩選', btnGroupDropValue: '' },
                { id: 2, btnGroupDropText: '我要找', btnGroupDropValue: '' },
                { id: 3, btnGroupDropText: '排序', btnGroupDropValue: 'totalRate' },
            ],
        }
        this.handleClick = this.handleClick.bind(this)
        this.submitSearch = this.submitSearch.bind(this)
    }
    handleClick(e) {
        let className = e.target.className.split(' ')[1]
        switch (className) {
            case 'filter_category':
                this.updateItem(1, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                break;
            case 'filter_region':
                this.updateItem(2, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                break;
            case 'sort':
                this.updateItem(3, { btnGroupDropText: e.target.innerHTML, btnGroupDropValue: e.target.value })
                break;
        }
        console.log(e.target.value)
        console.log(e.target.innerHTML)
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
    submitSearch(e) {
        let cdt = {}
        cdt.cold = this.state.chosen[0].btnGroupDropValue
        cdt.criteria = this.state.chosen[1].btnGroupDropValue
        cdt.orderby = this.state.chosen[2].btnGroupDropValue
        cdt.keyword = ''
        cdt.limitNumStart = 0
        cdt.limitNumEnd = 12
        let url = 'http://localhost:8080/reactSearch'
        fetch(url, {
            method: 'POST',
            headers: new Headers({
                'Content-Type': 'application/json'
            }),
            body: JSON.stringify(cdt),
        }).then(res => res.json())
            .then((data) => {
                this.setState({ stores: data })
            })
            .catch()
    }
    componentDidMount() {
        // let url = 'http://localhost:8080/reactLessThanThree'
        let url = 'http://localhost:8080/react'
        fetch(url)
            .then(res => res.json())
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
                        handleChange={this.handleChange}
                        chosen={this.state.chosen}
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