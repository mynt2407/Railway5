import React from 'react';
import AwesomeImage from './Image';
import withHover from './WithHover';


class UsingHover extends React.Component {
    render() {
        const ImageWithHover = withHover(AwesomeImage);
        return (
            <ImageWithHover />
        )
    }
}
export default UsingHover;