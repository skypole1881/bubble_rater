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
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/react')
            .then(res => res.json())
            .then((data) => {
                this.setState({ stores: data })
                console.log(this.state.stores[0])
            })
            .catch()
    }
    render() {
        // const stores = []
        // if(this.state.stores.length >= 3){
        //     for (let i = 3; i < this.state.stores.length; i ++) {
        //         stores.push(<Store key={this.state.stores[i].blogId} store={this.state.stores[i]} />);
        //     }
        // }
        
        // const storeTop = [];
        // if (this.state.stores.length >= 3) {
        //     for (let i = 0; i < 3; i++) {
        //         storeTop.push(<StoreTop key={i} rating={ratingArr[i]} store={this.state.stores[i]} />);
        //     }
        // }
        return (
            <div>
                <IntroContainer />
                <div className="container-fluid text-white" id="stores">
                    <Searchbar />
                    <div className="row no-gutters justify-content-md-center">
                        {
                            this.state.stores.slice(0,3).map(
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