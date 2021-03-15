import React from "react";
import Search from "../common/Search";
import NavPage from "../NavPage";
import "../../css/group.css";
import DeleteIcon from '@material-ui/icons/Delete';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import RefreshIcon from '@material-ui/icons/Refresh';
import FilterListIcon from '@material-ui/icons/FilterList';

// container
class GroupPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            groups: [
                {
                    name: "Java Fresher",
                    member: 18,
                    creator: "Vu Dinh Hao"
                },
                {
                    name: "PHP Fresher",
                    member: 20,
                    creator: "Nguyen Thi Giang"
                }
            ]
        };
    }

    render() {
        return (
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
            </div >
        );
    };
}

export default GroupPage;