import React from 'react'
import TableBody from './TableBody';
import TableHeader from './TableHeader';
import './table1.css'

class Table extends React.Component {
    render() {
        return (
            <table className="table">
                <TableHeader />
                <TableBody list={this.props.list} />
            </table>
        )
    }
}

export default Table;