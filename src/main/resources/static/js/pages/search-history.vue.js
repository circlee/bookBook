var searchHistory = Vue.component("SearchHistory", {
    template:
        `
         <div class="content-wrapper">
            <div class="page albums-index-page entity-index-page">
                <div class="content-header">
                    <h1 class="content-title">
                        <span>User Keywords</span>
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fas fa-dashboard"></i>
                            <a href="/" class="active">Home</a>
                        </li>
                        <li>User Keywords</li>
                    </ol>
                </div>
                <div class="content">
                    <div class="box">
                        <!---->
                        <div style="">
                            <div class="box-body table-responsive no-padding">
                                <table class="table entity-table table-bordered">
                                    <thead>
                                        <tr>
                                            <th class="item-cell-created-at" style="width:50%;"><span>Keyword</span>
                                            </th>
                                            <th class="item-cell-created-at"><span>CreatedAt</span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="item in searchResult.itemList">
                                            <td class="item-cell-id">
                                                <div>{{item.keyword}}</div>
                                            </td>
                                            <td  class="item-cell-created-at">
                                                <div class="display-datetime">{{formatDate(item.created_at)}}</div>
                                            </td>
                                        </tr>
                                        
                                    </tbody>
                                    <!---->
                                </table>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>`
    ,
    props: []
    , data: function () {
        return {
            searchResult: {
                itemList: []
            }
        };
    }
    , methods: {

        search : function(){
            var vueObj = this;

            axios.get('/api/search/my/keywords')
                .then(function(res){
                    var data = res.data;
                    Vue.set(vueObj.searchResult, 'itemList', data.items)
                });

        }
        , formatDate : function(date){
            var dt = new Date(date);
            var match = dt.toISOString().match(/(\d{4}\-\d{2}\-\d{2})T(\d{2}:\d{2}:\d{2})/)
            return match[1] + ' ' + match[2];
        }

    }
    ,mounted : function(){

        var vueObj = this;
        vueObj.search();

    }
});



