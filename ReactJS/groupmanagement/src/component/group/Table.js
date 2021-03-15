import * as React from 'react';
import { DataGrid } from '@material-ui/data-grid';

const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    { field: 'name', headerName: 'Group name', width: 200 },
    { field: 'member', headerName: 'Member', width: 200 },
    { field: 'creator', headerName: 'Creator', width: 200 },
    { field: 'createDate', headerName: 'Create Date', sortable: true, width: 260 }
];

export default function DataTable(props) {
    return (
        <div style={{ height: 400, width: '100%' }}>
            <DataGrid
              rows={props.rows} columns={columns} pageSize={5} checkboxSelection />
        </div>
    );
}