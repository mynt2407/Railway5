import React from 'react';
class ReadMore extends React.Component {
    constructor() {
        super();
        this.state = { showMore: false };
        this.getShowMore = this.getShowMore.bind(this);
    }

    getShowMore() {
        this.setState({ showMore: !this.state.showMore });
    }
    render() {
        return (
            <div>
                <h1>Welcome to ReactJS</h1>

                {
                    this.state.showMore ? (
                        <div>
                            <h4>Chẳng thể tìm được em</h4>
                            <p>Anh dừng chân, ngước nhìn trời cao ngàn muôn ánh sao
                            Để buồn đau phủ lên bờ vai hao gầy
                            Ngày mà ta rời xa, quay lưng về nhau
                                Liệu đã có ai ngoảnh lại</p>
                            <button onClick={this.getShowMore}>Show Less</button>
                        </div>) : (
                            <div>
                                <button onClick={this.getShowMore}>Read More</button>
                            </div>
                        )
                }
            </div>)
    }
}

export default ReadMore;