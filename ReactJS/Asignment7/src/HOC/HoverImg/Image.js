import React from 'react';

function AwesomeImage({ src = "https://picsum.photos/200/300", width = 300, height = 200 }) {

    return (
        <div style={{
            width: `${width}px`,
            height: `${height}px`,
            borderRadius: "10px",
            backgroundImage: `url(${src})`,
            backgroundSize : "cover"

        }}>
        </div>
    )
}

export default AwesomeImage;