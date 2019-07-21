var signup = Vue.component("Signup", {
    template:
        `<div class="login-box">
            <div class="login-logo" style="color: white;">BookBook <b>JOIN</b></div>
            <div class="login-box-body">
            <p class="login-box-msg">
                <span>Member JOIN</span>
            </p>
            <form @submit.prevent="submit">
                <div class="form-group has-feedback">
                    <input placeholder="Id : e-mail" class="form-control" v-model="email">
                </div>
                <div class="form-group has-feedback">
                    <input type="password" placeholder="Password" class="form-control" v-model="password">
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">SignUp</button>
                    </div>
                </div>
            </form>
        </div>
    </div>`
    ,
    props: []
    , data : function(){
        return { email:''
            , password:''
        };
    }
    , methods : {
        submit : function(e){

            axios.post('/auth/signup', {
                email: this.email,
                password: this.password,
            })
            .then(function(res) {
                alert('가입되었습니다.')
                router.push('/view/index')
            }, function() {
                console.error(arguments);
            });
        }
    }
});