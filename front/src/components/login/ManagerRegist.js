import React, { useState } from "react";
import {
  Button,
  FormControl,
  Grid,
  InputAdornment,
  InputLabel,
  MenuItem,
  Paper,
  Select,
  TextField,
  Typography,
  Link,
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import apiService from "../../services/ApiService";
import { useNavigate } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  },
  paper: {
    margin: theme.spacing(8, 4),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    backgroundColor: "rgba(255, 255, 255, 0.9)",
    padding: theme.spacing(4),
  },
  form: {
    width: "100%",
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    backgroundColor: "#f44336",
    "&:hover": {
      backgroundColor: "#d32f2f",
    },
  },
}));

const ManagerRegist = () => {
  let navigate = useNavigate();
  const classes = useStyles();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
    name: "",
    phone: "",
    address: "",
    addressDetail: "",
    managerLevel: "",
    stadiumName: "",
    stadiumArea: "",
    stadiumAddress: "",
    stadiumAddressDetail: "",
    workStartTime: "",
    workEndTime: "",
    fieldType: "",
    indoorStatus: "",
  });

  const regions = [
    "Seoul",
    "Busan",
    "Incheon",
    "Daegu",
    "Gwangju",
    "Daejeon",
    "Ulsan",
    "Sejong",
    "Gyeonggi-do",
    "Gangwon-do",
    "Chungcheongbuk-do",
    "Chungcheongnam-do",
    "Jeollabuk-do",
    "Jeollanam-do",
    "Gyeongsangbuk-do",
    "Gyeongsangnam-do",
    "Jeju-do",
  ];

  const menuStartItems = [];
  const menuEndItems = [];

  for (let i = 0; i <= 24; i += 2) {
    const value = i.toString().padStart(2, "0");
    const label = `${value}:00`;

    menuStartItems.push(
      <MenuItem key={value} value={value}>
        {label}
      </MenuItem>
    );
  }

  for (let i = 0; i <= 24; i += 2) {
    const value = i.toString().padStart(2, "0");
    const label = `${value}:00`;

    menuEndItems.push(
      <MenuItem key={value} value={value}>
        {label}
      </MenuItem>
    );
  }

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = () => {
    if (true) {
      const apiParam = formData;

      apiService
        .post("stadiumManager/regist", apiParam)
        .then((response) => {
          navigate("/login");
        })
        .catch(({ response }) => {
          console.log(response);
        });
    }
  };

  return (
    <Grid container component='main' className={classes.root}>
      <Grid item xs={false} sm={4} md={7} />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <Typography component='h1' variant='h5'>
            Sign up
          </Typography>
          <div className={classes.form}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  label='Email'
                  name='email'
                  value={formData.email}
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  label='Password'
                  name='password'
                  type='password'
                  value={formData.password}
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  label='Name'
                  name='name'
                  value={formData.name}
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  name='phone'
                  label='Phone'
                  type='tel'
                  id='phone'
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position='start'>+82</InputAdornment>
                    ),
                  }}
                  value={formData.phone}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  name='address'
                  label='Address'
                  id='address'
                  value={formData.address}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='addressDetail'
                  label='Address Detail'
                  id='addressDetail'
                  value={formData.addressDetail}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='managerLevelLabel'>Manager Level</InputLabel>
                  <Select
                    labelId='managerLevelLabel'
                    id='managerLevel'
                    name='managerLevel'
                    value={formData.managerLevel}
                    onChange={(e) => handleChange(e)}
                    label='Manager Level'
                  >
                    <MenuItem value='주'>Leader</MenuItem>
                    <MenuItem value='부'>Member</MenuItem>
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12}>
                <Typography variant='subtitle1'>Stadium info</Typography>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='stadiumName'
                  label='Stadium Name'
                  id='stadiumName'
                  value={formData.stadiumName}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='stadiumAreaLabel'>Stadium Area</InputLabel>
                  <Select
                    labelId='stadiumAreaLabel'
                    id='stadiumArea'
                    name='stadiumArea'
                    value={formData.stadiumArea}
                    onChange={(e) => handleChange(e)}
                    label='Stadium Area'
                  >
                    {regions.map((region) => (
                      <MenuItem key={region} value={region}>
                        {region}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  id='stadiumAddress'
                  label='Stadium Address'
                  name='stadiumAddress'
                  value={formData.stadiumAddress}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  id='stadiumAddressDetail'
                  label='Stadium AddressDetail'
                  name='stadiumAddressDetail'
                  value={formData.stadiumAddressDetail}
                  onChange={(e) => handleChange(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='workStartTime'>
                    Stadium Work StartTime
                  </InputLabel>
                  <Select
                    labelId='workStartTime'
                    id='workStartTime'
                    name='workStartTime'
                    value={formData.workStartTime}
                    onChange={(e) => handleChange(e)}
                    label='Work StartTime'
                  >
                    {menuStartItems}
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='workEndTime'>Stadium Work EndTime</InputLabel>
                  <Select
                    labelId='workEndTime'
                    id='workEndTime'
                    name='workEndTime'
                    value={formData.workEndTime}
                    onChange={(e) => handleChange(e)}
                    label='Work EndTime'
                  >
                    {menuEndItems}
                  </Select>
                </FormControl>
              </Grid>{" "}
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='fieldType'>fieldType</InputLabel>
                  <Select
                    labelId='fieldType'
                    id='fieldType'
                    name='fieldType'
                    value={formData.fieldType}
                    onChange={(e) => handleChange(e)}
                    label='Field Type'
                  >
                    <MenuItem value='풋살'>풋살</MenuItem>
                    <MenuItem value='대경기'>대경기</MenuItem>
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='indoorStatus'>Indoor Status</InputLabel>
                  <Select
                    labelId='indoorStatus'
                    id='indoorStatus'
                    name='indoorStatus'
                    value={formData.indoorStatus}
                    onChange={(e) => handleChange(e)}
                    label='Indoor Status'
                  >
                    <MenuItem value='내부'>내부</MenuItem>
                    <MenuItem value='외부'>외부</MenuItem>
                  </Select>
                </FormControl>
              </Grid>
            </Grid>
            <Button
              type='submit'
              fullWidth
              variant='contained'
              color='primary'
              className={classes.submit}
              onClick={handleSubmit}
            >
              Register
            </Button>
            <Grid container justify='flex-end'>
              <Grid item>
                <Link href='/login' variant='body2'>
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </div>
        </div>
      </Grid>
    </Grid>
  );
};
export default ManagerRegist;
