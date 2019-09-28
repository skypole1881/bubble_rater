import React from 'react'
import Searchbar from './Searchbar'
import { StoreTop } from './StoreTop'
// import IntroBot from './introduction/IntroBot'
// import IntroMain from './introduction/IntroMain'
// import IntroSub from './introduction/IntroSub'
// import IntroDetail from './introduction/IntroDetail'
import IntroContainer from './introduction/IntroContainer'
import { Store } from './Store';

const ratingArr = ["第一名", "第二名", "第三名"];

class MainContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            numberofblogs: 6,
            blogs: [],
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/react')
            .then(res => res.json())
            .then((data) => {
                this.setState({ blogs: data })
                console.log(this.state.blogs[0])
            })
            .catch()
    }
    render() {
        const blogs = [];
        for (let i = 0; i < this.state.numberofblogs; i += 1) {
            blogs.push(<Store key={i} />);
        }
        const storeCount = this.state.blogs.length
        const storeTop = [];
        if (this.state.blogs.length >= 3) {
            for (let i = 0; i < 3; i++) {
                storeTop.push(<StoreTop key={i} rating={ratingArr[i]} store={this.state.blogs[i]} />);
            }
        }
        return (
            <div>
                <IntroContainer />
                <div className="container-fluid text-white" id="stores">
                    <Searchbar />
                    <div className="row no-gutters justify-content-md-center">
                        {
                            this.state.blogs.length >= 3 && (
                                ratingArr.map(
                                    (rating, index) => {
                                        return <StoreTop key={index} rating={rating} blog={this.state.blogs[index]} />
                                    }
                                )
                            )
                            // :
                            // (
                            //     (storeCount) => {
                            //         for(let i = 0; i < storeCount; i ++){
                            //             return <StoreTop key={i} rating={ratingArr[i]} blog={this.state.blogs} />
                            //         }
                            //     }
                            // )
                        }
                    </div>
                    <div id="blogAppend" className="row no-gutters justify-content-md-center">
                        {
                            blogs
                        }
                    </div>
                </div>
            </div>
        )
    }
}

export default MainContent