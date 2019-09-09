import React from 'react';
import './App.css';
import './single-store.css'
import './bootstrap.min.css'
// import './blog-home.css'
import './post.css'
import {Navbar} from './components/Navbar'
import Header from './components/Header'
import MainContent from './components/MainContent'

function App() {
  return (
    <div>
      <Navbar />
      <Header />
      <MainContent />
    </div>
    // <div className="col-mdtext-white otherstore change-top">
    //   <div className="otherinfo">
    //     <div className="bg-blur">
    //       <table className="storenatext-center">
    //         <tbody>
    //           <tr>
    //             <td>
    //               <div text="">清心</div>
    //             </td>
    //             <td rowSpan="3">
    //               <div text="">8.9</div>
    //             </td>
    //           </tr>
    //           <tr>
    //             <td>
    //               <div text="">宜蘭縣蘇澳鎮</div>
    //             </td>
    //           </tr>
    //           <tr>
    //             <td>
    //               <div text="">珍奶半糖去冰</div>
    //             </td>
    //           </tr>
    //         </tbody>
    //       </table>
    //     </div>
    //   </div>
    //   <div className="othercomment change-second bg-blur">
    //     <div>
    //       <table className="storename">
    //         <tbody>
    //           <tr>
    //             <td>
    //               <div>清心</div>
    //             </td>
    //             <td rowSpan="2">
    //               <div>8.9</div>
    //             </td>
    //           </tr>
    //           <tr>
    //             <td>
    //               <div >珍奶半糖去冰</div>
    //             </td>
    //           </tr>
    //         </tbody>
    //       </table>
    //       <table className="scoretable">
    //         <tbody>
    //           <tr>
    //             <td >珍珠彈性</td>
    //             <td >90</td>
    //             <td >珍探給分</td>
    //             <td >90</td>
    //           </tr>
    //           <tr>
    //             <td text="">奶茶濃度</td>
    //             <td text="">90</td>
    //             <td text="">甜度等級</td>
    //             <td text="">中等</td>
    //           </tr>
    //         </tbody>
    //       </table>
    //       <p className="comment" text="">
    //         小編評價巴拉巴拉巴拉
    //         小編評價巴拉巴拉巴拉
    //         小編評價巴拉巴拉巴拉
    //         </p>
    //       <button type="button" className="btn btn-outline-light btn-sm modal-btn"
    //       >顯示更多</button>
    //       <a href=""
    //         className="btn btn-outline-light btn-sm single-link">顯示更多</a>
    //       <div className="d-none" id="invisibleId" >看不到</div>
    //     </div>
    //   </div>
    //   <div className="newstore">
    //     新 進 榜
    //     </div>
    // </div>
  )
}

export default App;
