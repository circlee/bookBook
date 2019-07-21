var detail = Vue.component("Detail", {
    template: `<div>
    <div style="margin-bottom: 10px;">Detail</div>
</div>`,
    props: ["title"],
    $_veeValidate: {
        validator: "new"
    },
    data() {
        return {
            arriveDepart: [],
            groundDelay: [],
            groundStop: [],
            result: null,
            showProgress: false
        };
    },
    created() {
        this.GetDelays();
    },
    methods: {
        GetDelays() {
            let url =
                "https://cors-anywhere.herokuapp.com/https://soa.smext.faa.gov/asws/api/airport/delays";
            this.showProgress = true;
            //let resp = fetchGet("https://soa.smext.faa.gov/asws/api/airport/delays");
            //console.log(resp);
            axios
                .get(url)
                .then(result => {
                    //console.log("result=", result);
                    data = result.data;
                    this.result = data;
                    this.arriveDepart = data.ArriveDepartDelays.arriveDepart;
                    this.groundDelay = data.GroundDelays.groundDelay;
                    this.groundStop = data.GroundStops.groundStop;
                    this.showProgress = false;
                })
                .catch(error => {
                    console.log("error", error);
                    this.showProgress = false;
                });
        }
    }
});