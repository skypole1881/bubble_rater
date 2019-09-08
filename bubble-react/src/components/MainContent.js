import React from 'react'
import Searchbar from './Searchbar'
import { StoreTop } from './StoreTop'

const ratingArr = ["第一名", "第二名", "第三名"];
class MainContent extends React.Component {
    render() {
        return (
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
            </div>
        )
    }
}

export default MainContent