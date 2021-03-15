import Api from './Api';

const url = "/groups";

const getAll = (page, size, sortField, sortType, search, minTotalMember, maxTotalMember) => {

    // default parameters
    if (sortField === null || sortField === undefined || sortType === null || sortType === undefined) {
        sortField = "id";
        sortType = "desc";
    }

    const requestParams = {
        page,
        size,
        sort: `${sortField},${sortType}`,
        search,
        minTotalMember,
        maxTotalMember
    }

    if (minTotalMember) {
        requestParams.minTotalMember = minTotalMember;
    }

    if (maxTotalMember) {
        requestParams.maxTotalMember = maxTotalMember;
    }

    return Api.get(url, { params: requestParams });
};

// export
const api = { getAll }
export default api;