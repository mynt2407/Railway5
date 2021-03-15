import React from 'react'
//import Footer from './Footer';
import Header from './Header';
import Navi from './Navi';
import Footer from './Footer';
import Main from './Main';
import './table.css';
import './container.css';
import './table.css';


class Table2 extends React.Component {
    render() {
        return (
            
            <div className="table">
                <div className = "div1">
                <Header />
                <Navi />
                <Main />
                <Footer />
                </div>
            </div>
            
        )
    }
}

export default Table2;