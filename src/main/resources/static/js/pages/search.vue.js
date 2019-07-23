var search = Vue.component("Search", {
    template:
        `
         <div class="content-wrapper">
            <div class="page albums-index-page entity-index-page">
                <div class="content-header">
                    <h1 class="content-title">
                        <span>Books</span>
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fas fa-dashboard"></i>
                            <a href="/" class="active">Home</a>
                        </li>
                        <li>Books</li>
                    </ol>
                </div>
                <div class="content">
                    <div class="box">
                        <!---->
                        <div style="">
                            <div class="box-header with-border">
                                <div class="row">
                                    
                                    <div class="col-lg-3 col-md-6">
                                        <div class="form-group">
                                            <input placeholder="Keyword" 
                                            class="form-control field" 
                                            stagger="300" 
                                            v-model="searchCondition.keyword"
                                            >
                                        </div>
                                        <input type="button" value="검색" @click="searchBtn" style="width:150px;" class="btn btn-primary btn-block btn-flat">
                                    </div>
                                </div>
                                <div class="entity-filters">
                                    <div class="row"></div>
                                </div>
                            </div>
                            <div class="box-body table-responsive no-padding">
                                <table class="table entity-table table-bordered">
                                    <thead>
                                        <tr>
                                            <th class="item-cell-id"><span>ISBN</span>
                                            </th>
                                            <th class="item-cell-created-at"><span>Name</span>
                                            </th>
                                            <th class="item-cell-slug"><span>Author</span>
                                            </th>
                                            <th class="item-cell-name"><span>Publisher</span>
                                            </th>
                                            <th class="table-item-actions"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="item in searchResult.itemList">
                                            <td class="item-cell-id">
                                                <div><a @click="modalOpen(item)" style="cursor: pointer;">{{item.isbn}}</a></div>
                                            </td>
                                            <td  class="item-cell-created-at">
                                                <div class="display-datetime" v-html="item.title"></div>
                                            </td>
                                            <td  class="item-cell-slug">
                                                <div>{{item.authors}}</div>
                                            </td>
                                            <td id="albums-item-1-name" class="item-cell-name">
                                                <div>{{item.publisher}}</div>
                                            </td>
                                        </tr>
                                        <tr v-if="searchResult.itemList.length <= 0">
                                            <td class="item-cell-slug" colspan="4">
                                                <div>결과가 없습니다.</div>
                                            </td>
                                        </tr>
                                        
                                    </tbody>
                                    <!---->
                                </table>
                            </div>
                            <nav class="pager-wrapper box-footer">
                            <kd-pagination 
		                           :curr-page-num="extSearchCondition.pageNo"
		                           :page-limit="extSearchCondition.limit"
		                           :total-count="searchResult.totalCount"
		                     ></kd-pagination>    
                            </nav>
                            <modal v-if="showModal" @close="showModal = false" :modal-data="modalData">
                                
                                <div slot="body">
                                    <ul>
                                    <li><span>제목</span> : <span v-html="modalData.title"></span></li>
                                    <li><span>도서 썸네일</span> : <span><img v-bind:src="modalData.thumbnail"></span></li>
                                    <li><span>소개</span> : {{modalData.contents}}</li>
                                    <li><span>ISBN</span> : {{modalData.isbn}}</li>
                                    <li><span>저자</span> : {{modalData.authors}}</li>
                                    <li><span>출판사</span> : {{modalData.publisher}}</li>
                                    <li><span>출판일</span> : {{modalData.pub_date}}</li>
                                    <li><span>정가</span> : {{modalData.price}}</li>
                                    <li><span>판매가</span> : {{modalData.sale_price}}</li>
                                    </ul>
                                </div>
                              </modal>
                        </div>
                    </div>
                </div>
            </div>
        </div>`
    ,
    props: []
    , data: function () {
        return {
            searchCondition: {
                keyword: ''
            }
            , saveSearchCondition: {}
            , extSearchCondition: {
                limit: 10
                , pageNo: 1
            }
            , searchResult: {
                totalCount: 0
                , itemList: []
            }
            , showModal : false
            , modalData : null
        };
    }
    , methods: {

        searchBtn : function(){
            var vueObj = this;
            vueObj.extSearchCondition.pageNo = 1;
            vueObj.saveSearchCondition = Object.assign({}, vueObj.searchCondition);
            vueObj.search();
        }
        , search : function(){
            var vueObj = this;

            var params = Object.assign(vueObj.saveSearchCondition, vueObj.extSearchCondition);

            axios.get('/api/books'
                , {params : params})
                .then(function(res){
                    var data = res.data;
                    Vue.set(vueObj.searchResult, 'itemList', data.items)
                    //vueObj.searchResult.itemList = data.items;
                    vueObj.searchResult.totalCount = data.total_count;
                });

        }
        , pageChange : function(pageNo){
            var vueObj = this;
            vueObj.extSearchCondition.pageNo = pageNo;
            vueObj.search();

        }
        , modalOpen : function(data){
            var vueObj = this;
            vueObj.modalData = data;
            vueObj.showModal = true;
        }

    }
    ,created : function(){

        var vueObj = this;
        //pageChange
        vueObj.$on('kd-pageChange' , function(n){
            this.pageChange(n);
        });

    }
});



Vue.component('modal', {
    template: `<transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">


          <div class="modal-body">
            <slot name="body">
              default body
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <button class="modal-default-button" @click="$emit('close')" style="width:150px;" class="btn btn-primary btn-block btn-flat">
                OK
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>`
    , props : ['modalData']
})