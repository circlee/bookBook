var kdPagination = Vue.component( 'kd-pagination',

    {
        template :
            '<ul v-if="isShow" class="pagination">\
              <li class="page_prev"\
              :style="{cursor : (isValidSetPageNum(currPageNum -1) ? \'pointer\' : \'not-allowed\')}"\
              @click="setPageNum(currPageNum -1)"\
              >prev</li>\
              \
              <li class="page_num" \
              v-for="idx in showPageNum" \
              v-append-skip-front="frontSkipIdx == idx && showFrontSkip"\
              v-append-skip-back="backSkipIdx == idx && showBackSkip"\
              v-append-part="showPageNum == idx"\
              :class="{\'page_curr\' : pageItemArr[idx] == currPageNum}"\
              @click="setPageNum(pageItemArr[idx])"\
              >{{pageItemArr[idx]}}</li>\
              \
              <li class="page_next"\
                 :style="{cursor : (isValidSetPageNum(currPageNum +1) ? \'pointer\' : \'not-allowed\')}"\
                 @click="setPageNum(currPageNum + 1)"\
              >next</li>\
          </ul>'
        ,props : ['currPageNum','totalCount', 'pageLimit' , 'pageHandler']

        ,data : function(){
            return {
                isShow : false
                ,showPageNum : 0
                ,frontSkipIdx : 2
                ,showFrontSkip : false
                ,backSkipIdx : 7
                ,showBackSkip : false
                ,pageItemArr : []
                ,totalPageNum : 0
            }
        }
        , methods : {
            setVal : function(key, val){
                this[key] = val;
            },
            render : function(){

                this.isShow = false;

                if(!this.pageLimit){
                    return ;
                }

                if(!this.totalCount){
                    return ;
                }


                if(!this.currPageNum){
                    return ;
                }
                this.isShow = true;

                $(this.$el).children('.skip_front').remove();
                $(this.$el).children('.skip_back').remove();


                var pageLimit = this.pageLimit;
                var totalCount = this.totalCount;
                var currPageNum = this.currPageNum;

                // 전체갯수와 페이지리밋으로 전체 페이지 갯수 구하
                var totalPageNum = parseInt(totalCount / pageLimit)
                    + (totalCount % pageLimit > 0 ? 1 : 0);

                this.totalPageNum = totalPageNum;

                if(currPageNum > totalPageNum) {
                    this.setPageNum(totalPageNum);
                }

                //sample
                this.showPageNum = totalPageNum;

                var pageItemArr = this.pageItemArr;

                this.showFrontSkip = false;
                this.showBackSkip = false;

                if(totalPageNum > 9) {
                    this.showPageNum = 9;

                    this.showFrontSkip = true;
                    this.showBackSkip = true;

                    pageItemArr[1] = 1;
                    pageItemArr[2] = pageItemArr[1] + 1;

                    pageItemArr[9] = totalPageNum;
                    pageItemArr[8] = pageItemArr[9] - 1;

                    var offSet = 0;
                    if(pageItemArr[8] <= (currPageNum + 3)) {
                        this.showBackSkip = false;
                        offSet = pageItemArr[8] - (currPageNum + 3);

                    }

                    if(pageItemArr[2] >= (currPageNum - 3)) {
                        this.showFrontSkip = false;
                        offSet =  pageItemArr[2] - (currPageNum - 3);
                    }

                    pageItemArr[3] = currPageNum - 2 + offSet;
                    pageItemArr[4] = currPageNum - 1 + offSet;
                    pageItemArr[5] = currPageNum + offSet;
                    pageItemArr[6] = currPageNum + 1 + offSet;
                    pageItemArr[7] = currPageNum + 2 + offSet;

                } else {
                    for(var i = 0 ; i <= 10 ; i++) {
                        pageItemArr[i] = i;
                    }
                }

            }
            , isValidSetPageNum : function(n){
                if(1 <= n && n <= this.totalPageNum) {
                    return true;
                }
                return false;
            }
            , setPageNum :function(n){
                if(this.isValidSetPageNum(n)) {
                    this.$parent.$emit('kd-pageChange' , n);
                }
            }
            , initPage : function(){
                this.currPageNum = 1;
            }
        }
        , directives :{
            appendPart : {
                inserted : function(el ,binding , value){

                }
                ,componentUpdated : function(el ,binding , value){

                }

            }
            ,appendSkipFront : {
                inserted : function(el ,binding , value){
                    if(binding.value) {
                        $('<li class="skip_front">...</li>').clone().insertAfter($(el))
                    }
                }
                ,componentUpdated :function(el ,binding , valuWe){
                    $(el).next('.skip_front').remove();
                    if(binding.value) {
                        $('<li class="skip_front">...</li>').clone().insertAfter($(el))
                    }
                }
            }
            ,appendSkipBack : {
                inserted : function(el ,binding , value){
                    if(binding.value) {
                        $('<li class="skip_back">...</li>').clone().insertAfter($(el))
                    }
                }
                ,componentUpdated :function(el ,binding , value){
                    $(el).next('.skip_back').remove();
                    if(binding.value) {
                        $('<li class="skip_back">...</li>').clone().insertAfter($(el))
                    }
                }
            }
        }
        , created : function(){

            this.render();

            this.$watch(function(){
                return this.currPageNum;
            } , function(c){
                this.render();
            });

            this.$watch(function(){
                return this.totalCount;
            } , function(c){
                this.render();
            });

            this.$watch(function(){
                return this.pageLimit;
            } , function(c){
                this.render();
            });

        }

    });