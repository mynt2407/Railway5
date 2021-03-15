import React from 'react'
import Table from './Table';

class Table1 extends React.Component {

    constructor(props) {
        super(props);
        this.data = [
            {
                language: "PHP",
                framework: "Laravel"
            },
            {
                language: "Android",
                framework: "Webkit"
            },
            {
                language: "Java",
                framework: "Meteor"
            }
        ];
    }
    render() {
        return (
            <Table list={this.data} />
        );
    }
}
export default Table1;
