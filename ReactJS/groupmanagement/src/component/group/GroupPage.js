import React, { useEffect, useState } from "react";
import Search from "../common/Search";
//import NavPage from "../NavPage";
import "../../css/group.css";
import DeleteIcon from '@material-ui/icons/Delete';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import RefreshIcon from '@material-ui/icons/Refresh';
import FilterListIcon from '@material-ui/icons/FilterList';
import TableGroup from "./TableGroup";
import { selectListEmployees, selectLoadings } from "../../redux/selector/GroupSelector";
import store from "../../redux/Store";
import { getListEmployeeAsyncAction } from "../../redux/reducer/GroupSlice";
import WithLoading from "../../hoc/withLoading";

// container
function GroupPage() {
    const [groups, setGroup] = useState(selectListEmployees());
    const [isLoading, setLoading] = useState(selectLoadings());

    const updateFromStore = () => {
        store.subscribe(
            () => {
                setGroup(selectListEmployees());
                setLoading(selectLoadings());
            }
        )
    }
    updateFromStore();
    const getListEmployee = () => {
        store.dispatch(getListEmployeeAsyncAction());
    }
    useEffect(() => {
        getListEmployee()
    }, []);


    const GroupWithLoading = WithLoading(TableGroup)


    return (
        <>
        <div style={{ borderStyle: "solid", width: "100%" }}>
            {/* <NavPage /> */}
            {/* Header */}
                LIST GROUPS
            <div className="groupContainer">
                <Search className="searchItem" />
                <DeleteIcon />
                <AddCircleIcon />
                <RefreshIcon />
                <FilterListIcon />

            </div>
            <GroupWithLoading
                groups={groups}
                isLoading={isLoading}
            />
        </div >
        </>
    );
};



export default GroupPage;