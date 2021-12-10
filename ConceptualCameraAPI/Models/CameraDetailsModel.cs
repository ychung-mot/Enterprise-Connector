using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ConceptualCameraAPI.Models
{
    public class CameraDetailsModel
    {
        public int Id { get; set; }

        public string Description { get; set; }

        public double Latitude { get; set; }

        public double Longitude { get; set; }

        public string Devicetype { get; set; }

        public string OverlayText { get; set; }

        public string Capabilities { get; set; }

        public string Direction { get; set; }
    }
}
