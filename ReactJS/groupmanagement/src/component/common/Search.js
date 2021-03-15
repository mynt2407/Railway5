import React from "react";
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

// container
class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            value: ""
        };
    }

    render() {
        return (
            <div {...this.props}>
                <span>
                    <TextField id="outlined-search" label="Search field" type="search" variant="outlined" />
                    <Button variant="contained">Default</Button>
                </span>
            </div>
        );
    };
}

export default Search;