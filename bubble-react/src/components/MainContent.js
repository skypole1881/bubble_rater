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
        }
    }
    render() {
        const blogs = [];
        for(let i = 0; i < this.state.numberofblogs; i += 1)
        {
            blogs.push(<Store key = {i} />);
        }
        return (
            <div>
                <IntroContainer />
                <div className="container-fluid text-white" id="stores">
                    <Searchbar />
                    <div className="row no-gutters justify-content-md-center">
                        {
                            ratingArr.map(
                                (rating, index) => {
                                    return <StoreTop key={index} rating={rating} />
                                }
                            )
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