import React, { useState }  from 'react';

function useClock() {
    const [time, setTime] = useState("");
    const [ampm, setampm] = useState("");

    const updateTime = function () {
        const dateInfor = new Date();
        let hour = 0;

        //  Đổi giờ 24h sang 12h
        if (dateInfor.getHours() === 0) {
            hour = 12
        } else if (dateInfor.getHours() > 12) {
            hour = dateInfor.getHours() - 12
        }
        else {
            hour = dateInfor.getHours()
        }

        //Thêm '0' vào trước phút nếu < 10
        let minutes = dateInfor.getMinutes() < 10 ? '0' + dateInfor.getMinutes() : dateInfor.getMinutes()

        //Thêm '0' vào trước phút nếu < 10
        let second = dateInfor.getSeconds() < 10 ? '0' + dateInfor.getSeconds() : dateInfor.getSeconds()

        // Dinh dang am/ pm
        let ampm = dateInfor.getHours() < 12 ? ' AM' : ' PM'

        setampm(ampm)
        setTime(`${hour}:${minutes}:${second}`)

    }

    setInterval(
        function () {
            updateTime()
        }, 1000)

    return [time, ampm]
}
export default useClock;
