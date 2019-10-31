import React from 'react';
// import logo from './logo.svg';
import 'semantic-ui/dist/semantic.min.css';

class Post extends React.Component
{
    constructor(props) {
        super(props);
        this.state={};

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    componentDidMount() {
        if(this.props.id) {
            fetch('http://13.230.125.32:8080/v1/bubble/detail/' + this.props.id)
                .then(res => res.json())
                .then((data) => {
                    this.setState({ ...data, ...data.score })
                    console.log(this.state)
                })
                .catch()
        }
    }
    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;
        // console.log(name);
        this.setState({
            [name]: value
        });
    }
    handleSubmit(event) {
        fetch('http://13.230.125.32:8080/v1/bubble/detail', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify({
                country: this.state.country,
                city: this.state.city,
                district: this.state.district,
                address: this.state.address,
                name: this.state.name,
                content: this.state.content,
                item: this.state.item,
                photo: this.state.photo1,
                cold: this.state.cold,
                score:{
                    rawBubbleRate:this.state.rawBubbleRate,
                    rawTeaRate:this.state.rawTeaRate,
                    sweetnessRate:this.state.sweetnessRate,
                    godFeelingRate:this.state.godFeelingRate
            }}),})
            .then()
            .then((data) => {
                console.log(data)
            })
            .catch((m) => {console.log(m)})
    }
    render() {
        const blog = this.state;
        return (
            <div className="m-container m-padded-tb-big">
                <div className="ui container">
                    <form id="blog-form" action="" method="post" className="ui form">
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">標題</label>
                                    <input type="text" name="name" placeholder="標題" value={blog.name || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">品項</label>
                                    <input type="text" name="item" placeholder="品項" value={blog.item || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="required field">
                            <label className="ui compact teal basic label">心得內容</label>
                            <div id="md-content">
                                <textarea placeholder="心得内容" name="content" value={blog.content || ""} onChange = {this.handleInputChange}></textarea> 
                            </div>
                        </div>
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">店名</label>
                                    <input type="text" name="name" placeholder="店名" value={blog.name || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">地址</label>
                                    <input type="text" name="address" placeholder="地址" value={blog.address || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">城市名稱</label>
                                    <input type="text" name="city" placeholder="城市" value={blog.city || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">區</label>
                                    <input type="text" name="district" placeholder="區" value={blog.district || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">圖片連結</label>
                                    <input type="text" name="photo" placeholder="圖片連結" value={blog.photo || ""} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">冷</label>
                                    <input type="checkbox" name="cold" placeholder="冷" checked={!!blog.cold} onChange = {this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">珍珠分數</label>
                                    <input type="text" name="bubbleRate" placeholder="珍珠分數" value={blog.bubbleRate || ""} onChange={this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">茶分數</label>
                                    <input type="text" name="teaRate" placeholder="茶分數" value={blog.teaRate || ""} onChange={this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="two fields">
                            <div className="required field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">甜度</label>
                                    <input type="text" name="sweetnessRate" placeholder="甜度" value={blog.sweetnessRate || ""} onChange={this.handleInputChange}/>
                                </div>
                            </div>
                            <div className=" field">
                                <div className="ui left labeled action input">
                                    <label className="ui compact teal basic label">小編分數</label>
                                    <input type="text" name="godfeelingRate" placeholder="小編分數" value={blog.godfeelingRate || ""} onChange={this.handleInputChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="ui error message"></div>
                        <div className="ui right aligned container">
                            <button type="button" className="ui button" onClick="window.history.go(-1)">返回</button>
                            {/* <button type="button" id="save-btn" className="ui secondary button">保存</button> */}
                            <button type="button" id="publish-btn" className="ui teal button" onClick = {this.handleSubmit}>發布</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}
export default Post;