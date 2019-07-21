window.console = console || { log: function () { }, warn: function () { }, error: function () { } };
// axios.defaults.baseURL = '';
axios.defaults.timeout = 60000;
axios.defaults.headers.common['Content-Type'] = 'application/json';

axios.interceptors.request.use(function (config) {

    var token = document.querySelector("meta[name='_csrf']").content;
    var header = document.querySelector("meta[name='_csrf_header']").content;
    if(token && header) {
        config.headers.common[header] = token;
    }

    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});

axios.interceptors.response.use(function (res) {
    return Promise.resolve(res);
}, function (err) {
    if (err.response) {
        switch (err.response.status) {
            case 401:
                return location.href = '/view/index';
            case 403:
                return location.href = '/view/index';
            // case 400:
            //     return location.href = '/view/notFound';
            default:
                console.log(err.response.status, err.response);
                alert((err.response.data && err.response.data.message) || '오류가 발생하였습니다.' );
                break;
        }
    }
    return Promise.reject(err);
});
