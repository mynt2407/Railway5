import React from 'react';
import DataTable from './Table';

function TableGroup(props) {
    return (
        < DataTable
            rows={props.groups}
        />

    )
}

export default TableGroup;