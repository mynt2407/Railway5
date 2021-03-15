import React from 'react';
import Article from './Article';
import Section from './Section';
import Aside from './Aside';
import './container.css'



class Main extends React.Component {
    render() {
        return (
            <div className="container">

                <span className="article-section">
                    <div >
                        <Section />
                        <Article />
                    </div>
                </span >

                <span >
                    <Aside />
                </span>
            </div>


        )
    }
}

export default Main;